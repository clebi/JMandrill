/*
 Copyright 2015 Clément Bizeau

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.clebi.mandrill.exception;

import org.clebi.mandrill.model.ApiError;

/**
 * Mandrill Api error
 * This exception is thrown when there is a bad api call
 */
public class MandrillApiException extends MandrillException {
    
    private final ApiError error;

    public MandrillApiException(String message, ApiError error) {
        super(message + " - error: " + error.getMessage());
        this.error = error;
    }

    public ApiError getError() {
        return error;
    }

}
