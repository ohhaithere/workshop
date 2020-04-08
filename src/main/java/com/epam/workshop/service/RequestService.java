package com.epam.workshop.service;

import com.epam.workshop.model.Request;
import com.epam.workshop.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestService {

  private final RequestRepository requestRepository;
  private final AuditService auditService;

  public void saveRequest(String request) {
    Request requestModel = Request.builder().json(request).build();
    requestModel = requestRepository.save(requestModel);
    try {
      auditService.saveAudit(requestModel);
    } catch (Exception e) {
     log.error("Oops, something went wrong");
    }
  }

}
