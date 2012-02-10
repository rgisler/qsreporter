/*
 * Copyright 2012 Roland Gisler, GISLER iNFORMATiK, Switzerland.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * $Id: AbstractBpmsTask.java 38 2007-02-12 12:50:46Z rog $
 */
package ch.gitik.qsreporter.output;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;

/**
 * 
 * @author Roland Gisler
 */
public class ConsoleMessageTest extends ConsoleMessage {

   @Test
   public void testConsoleCheckstyle() {
      CheckstyleModel model = new CheckstyleModel(10,20,30);
      String console = ConsoleMessage.consoleCheckstyle(model);
      System.out.println(console);
      assertNotNull(console);
   }

}
