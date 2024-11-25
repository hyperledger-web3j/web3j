/*
 * Copyright 2024 Web3 Labs Ltd.
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
package org.web3j.codegen

import org.eclipse.jdt.internal.compiler.batch.Main
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.PrintWriter

class GeneraterTestUtils private constructor() {
    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun verifyGeneratedCode(sourceFile: String?) {
            requireNotNull(sourceFile) { "Source file cannot be null" }

            val outputStream = ByteArrayOutputStream()
            val printWriter = PrintWriter(outputStream)
            val compiler = Main(
                printWriter,
                printWriter,
                false,
                null,
                null
            )

            val result = compiler.compile(
                arrayOf(
                    sourceFile,
                    "-d",
                    "out", // Specify the output directory for compiled classes
                    "-classpath",
                    System.getProperty("java.class.path") // Include necessary classpath
                )
            )

            val compilerOutput = outputStream.toString()
            println(compilerOutput)
            assertTrue(result, "Generated contract contains compile-time errors:\n$compilerOutput")
        }
    }
}
