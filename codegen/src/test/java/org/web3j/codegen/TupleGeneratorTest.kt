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
package org.web3j.codegen

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.web3j.android_test_utils.TempFileProvider
import java.io.File
import java.io.IOException

class TupleGeneratorTest : TempFileProvider() {

    @Test
    @Throws(IOException::class)
    fun testTuplesGeneration() {
        TupleGenerator.main(arrayOf(tempDirPath))

        val baseDir =
            tempDirPath + File.separatorChar + TupleGenerator.PACKAGE_NAME.replace('.', File.separatorChar)

        val fileNameBase = baseDir + File.separator + TupleGenerator.CLASS_NAME
        val fileNames: MutableList<String> = ArrayList(TupleGenerator.LIMIT)
        for (i in 1..TupleGenerator.LIMIT) {
            fileNames.add("$fileNameBase$i.java")
        }
        verifyGeneratedCode(fileNames)
    }

    companion object {
        @Throws(IOException::class)
        fun verifyGeneratedCode(sourceFiles: List<String>) {
            for (sourceFile in sourceFiles) {
                val file = File(sourceFile)
                assertTrue(
                    file.exists() && file.isFile,
                    "Generated code file not found or is invalid: $sourceFile"
                )
            }
        }
    }
}
