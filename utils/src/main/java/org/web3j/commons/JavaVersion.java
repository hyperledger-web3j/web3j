/*
 * Copyright 2019 Web3 Labs Ltd.
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
package org.web3j.commons;

/**
 * A utility class to retrieve the current Java version.
 */
public class JavaVersion {

    /**
     * Returns the Java specification version as a string.
     * For example, "1.8" for Java 8 or "9" for Java 9 and above.
     *
     * @return the Java version as a string.
     */
    public static String getJavaVersion() {
        return System.getProperty("java.specification.version");
    }

    /**
     * Returns the Java specification version as a double.
     * For Java versions before 9 (e.g., Java 8), it returns the version number after "1."
     * (e.g., 8.0 for Java 1.8).
     * For Java versions 9 and above, it returns the version number directly
     * (e.g., 9.0 for Java 9).
     *
     * @return the Java version as a double.
     */
    public static double getJavaVersionAsDouble() {
        String version = System.getProperty("java.specification.version");
        if (version.startsWith("1.")) {
            // For versions before Java 9 (e.g., "1.8"), extract the part after "1."
            return Double.parseDouble(version.substring(2));
        } else {
            // For Java 9 and above (e.g., "9", "10"), parse the version directly
            return Double.parseDouble(version);
        }
    }
}
