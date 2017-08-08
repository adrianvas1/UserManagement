/*
 *
 * Copyright (c) 2016. Altisource Solutions. All rights reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Altisource Solutions and its suppliers,
 * if any. The intellectual and technical concepts contained
 * herein are proprietary to Altisource Solutions and its
 * suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or
 * copyright law. Dissemination of this information or
 * reproduction of this material is strictly forbidden unless
 * prior written permission is obtained from Altisource Solutions.
 *
 */

package com.users.exception;

import javax.ws.rs.core.Response;

import static com.users.util.Constants.DUPLICATE_EXCEPTION_ERROR_CODE;

/**
 * Exception raised whenever attempting to persist an entity that conflicts with data that's already persisted.
 *
 * @author vvaka
 */

@SuppressWarnings("unused")
public class RDDuplicateException {

    private String message;

    private String errorCode;

    public RDDuplicateException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public int getHttpCode() {
        return Response.Status.CONFLICT.getStatusCode();
    }
}
