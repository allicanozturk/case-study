package com.example.casestudy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  public EventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishEvent(ApplicationEvent event){
    applicationEventPublisher.publishEvent(event);
  }

}
