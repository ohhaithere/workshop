package com.epam.workshop.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.epam.workshop.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/audit"})
public class AuditController {

  private final RequestService requestService;

  @RequestMapping(value = "/greeting", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseBody
  public String auditTest(HttpEntity<String> httpEntity) throws Exception {
    String json = httpEntity.getBody();
    requestService.saveRequest(json);
    return json;
  }

}
