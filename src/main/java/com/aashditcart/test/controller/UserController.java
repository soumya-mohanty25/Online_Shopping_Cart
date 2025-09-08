package com.aashditcart.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aashditcart.test.model.User;
import com.aashditcart.test.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@ControllerAdvice
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
    @GetMapping("/dashboard")
    public String userDashboard(Model model,  HttpSession session) {
    	try {
            User user = (User) session.getAttribute("loggedInUser");
            if (user != null) {
                session.setAttribute("username", user.getFirstName());
                return "user-dashboard";
            } else {
                return "redirect:/users/login";
            }
        } catch (Exception e) {
            logger.error("Error loading dashboard: ", e);
            return "redirect:/users/login";
        }
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
    	try {
            model.addAttribute("user", new User());
            return "user-registration";
        } catch (Exception e) {
            logger.error("Error loading registration form: ", e);
            return "redirect:/users/login";
        }
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
    	try {
            userService.saveUser(user);
            logger.info("User registered successfully: {}", user.getUsername());
            model.addAttribute("successMessage", "Registration successful!");
            return "redirect:/users/dashboard";
        } catch (Exception e) {
            logger.error("Error during user registration: ", e);
            model.addAttribute("errorMessage", "Registration failed. Please try again.");
            return "user-registration";
        }
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "user-login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model,
                                HttpSession session) {
    	try {
            User user = userService.findByUsernameAndPassword(username, password);
            if (user != null) {
                session.setAttribute("loggedInUser", user);
                return "redirect:/users/profile";
            } else {
                model.addAttribute("errorMessage", "Invalid credentials. Please try again.");
                return "user-login";
            }
        } catch (Exception e) {
            logger.error("Login error: ", e);
            model.addAttribute("errorMessage", "Login failed. Try again.");
            return "user-login";
        }
    }

    @GetMapping("/logout")
    public String logoutCustomer(HttpSession session, SessionStatus sessionStatus) {
    	try {
            session.invalidate();
            sessionStatus.setComplete();
            return "redirect:/users/login";
        } catch (Exception e) {
            logger.error("Logout error: ", e);
            return "redirect:/users/login";
        } // Redirect to login page
    }


    @GetMapping("/profile")
    public String redirectToProfile(HttpSession session) {
    	try {
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
                return "redirect:/users/profile/" + loggedInUser.getId();
            } else {
                return "redirect:/users/login";
            }
        } catch (Exception e) {
            logger.error("Profile redirection error: ", e);
            return "redirect:/users/login";
        }
    }


    @GetMapping("/profile/{id}")
    public String showUserProfile(@PathVariable("id") Long id, Model model, HttpSession session) {
    	 try {
             User loggedInUser = (User) session.getAttribute("loggedInUser");
             if (loggedInUser != null && loggedInUser.getId().equals(id)) {
                 model.addAttribute("user", loggedInUser);
                 return "user-profile";
             }
             return "redirect:/users/login";
         } catch (Exception e) {
             logger.error("Error displaying profile: ", e);
             return "redirect:/users/login";
         }
    }

    @GetMapping("/edit-profile/{id}")
    public String editCustomerProfile(@PathVariable("id") Long id, Model model, HttpSession session) {
    	try {
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null && loggedInUser.getId().equals(id)) {
                model.addAttribute("user", loggedInUser);
                return "user-editProfile";
            }
            return "redirect:/users/profile";
        } catch (Exception e) {
            logger.error("Error editing profile: ", e);
            return "redirect:/users/profile";
        }
    }
  

    @PostMapping("/update-profile/{id}")
    public String updateUserProfile(@ModelAttribute User user, @PathVariable("id") Long id,
                                    HttpSession session,
                                    RedirectAttributes redirectAttributes) {
    	try {
            User existingUser = userService.findById(id);
            if (existingUser != null) {
                existingUser.setFirstName(user.getFirstName());
                existingUser.setLastName(user.getLastName());
                existingUser.setUsername(user.getUsername());
                existingUser.setEmail(user.getEmail());
                existingUser.setPhoneNumber(user.getPhoneNumber());
                existingUser.setGender(user.getGender());
                existingUser.setDateOfBirth(user.getDateOfBirth());

                userService.updateUser(existingUser);
                session.setAttribute("loggedInUser", existingUser);

                redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
            }
            return "redirect:/users/profile/" + id;
        } catch (Exception e) {
            logger.error("Error updating profile: ", e);
            redirectAttributes.addFlashAttribute("error", "Failed to update profile.");
            return "redirect:/users/profile/" + id;
        }
    }



    @GetMapping("/contactus")
    public String showContactus()
    {
    	 try {
             return "user-contactus";
         } catch (Exception e) {
             logger.error("Error loading Contact Us page: ", e);
             return "user-dashboard";
         }
    }
}
