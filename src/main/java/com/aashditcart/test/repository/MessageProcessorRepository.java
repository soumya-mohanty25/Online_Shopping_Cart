package com.aashditcart.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.MessageProcessor;

public interface MessageProcessorRepository extends JpaRepository<MessageProcessor, Long> {

	MessageProcessor findByTemplateName(String templateName);

	List<MessageProcessor> findByIsSend(Boolean isSend);
}
