package com.example.casestudy.dto.model;

import com.example.casestudy.util.GeneralEnumerationDefinition;

public class OperationResult {

 private GeneralEnumerationDefinition.OperationResultCode operationResultCode;
 private String errorId;
 private String description;


  public static OperationResult newInstance(GeneralEnumerationDefinition.OperationResultCode resultCode) {
    OperationResult result = new OperationResult();
    result.setOperationResultCode(resultCode);
    return result;
  }

  public static OperationResult createErrorResult(String errorId, String description){
    OperationResult result = new OperationResult();
    result.setOperationResultCode(GeneralEnumerationDefinition.OperationResultCode.ERROR);
    result.setErrorId(errorId);
    result.setDescription(description);
    return result;
  }


  public GeneralEnumerationDefinition.OperationResultCode getOperationResultCode() {
    return operationResultCode;
  }

  public void setOperationResultCode(GeneralEnumerationDefinition.OperationResultCode operationResultCode) {
    this.operationResultCode = operationResultCode;
  }

  public String getErrorId() {
    return errorId;
  }

  public void setErrorId(String errorId) {
    this.errorId = errorId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
