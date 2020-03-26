package com.epam.workshop.service;

import com.epam.workshop.model.AuditModel;
import com.epam.workshop.model.RequestModel;
import com.epam.workshop.repository.AuditRepository;
import java.util.Date;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {

  private final AuditRepository auditRepository;

  public void saveAudit(RequestModel requestModel) throws Exception {
    AuditModel auditModel =  AuditModel.builder()
        .httpRequest(requestModel.getJson())
        .requestId(requestModel.getId())
        .requestDate(new Date()).build();
    Random rand = new Random();
    Integer n = rand.nextInt(1000);
    if (n % 7 != 0) {
      auditRepository.save(auditModel);
    } else {
      throw new Exception();
    }
  }

}
