package com.example.casestudy.dto.response;

import com.example.casestudy.dto.model.OperationResult;
import com.example.casestudy.util.GeneralEnumerationDefinition;


public class GenericResponse<T> {
  private T data;
  private OperationResult operationResult;


  public static <T> GenericResponse createSuccessfulResponse(T data) {
    OperationResult operationResult = OperationResult.newInstance(GeneralEnumerationDefinition.OperationResultCode.SUCCESSFUL);
    GenericResponse response = new GenericResponse();
    response.setOperationResult(operationResult);
    response.setData(data);
    return response;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public OperationResult getOperationResult() {
    return operationResult;
  }

  public void setOperationResult(OperationResult operationResult) {
    this.operationResult = operationResult;
  }
}
