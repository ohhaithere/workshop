package com.epam.workshop.service;

import com.epam.workshop.model.Audit;
import com.epam.workshop.model.Request;
import com.epam.workshop.repository.AuditRepository;
import java.util.Date;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {

  private final AuditRepository auditRepository;

  public void saveAudit(Request request) throws Exception {
    Audit audit =  Audit.builder()
        .httpRequest(request.getJson())
        .requestId(request.getId())
        .requestDate(new Date()).build();
    Random rand = new Random();
    Integer n = rand.nextInt(1000);
    if (n % 7 != 0) {
      auditRepository.save(audit);
    } else {
      throw new Exception();
    }
  }

}
