/*
 * Copyright 2019 Web3 Labs LTD.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.utils;

public enum Restriction {
    RESTRICTED("restricted"),
    UNRESTRICTED("unrestricted");

    private String restriction;

    Restriction(final String restriction) {

        this.restriction = restriction;
    }

    public String getRestriction() {
        return restriction;
    }

    public static Restriction fromString(final String text) {
        for (Restriction b : Restriction.values()) {
            if (b.toString().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}