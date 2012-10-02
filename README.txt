 *
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
 * -----------------------------------------------------------------------
 
 Ant-Task mit welchem die Ergebnisse (Summen) von 
 
 - Checkstyle
 - Classycle
 - PMD 
 
 sowie von 
 
 - JaCoCo (eclemma, Coverage)
 
 aus deren XML-Reports gelesen und auf der Konsole ausgegeben werden.
 Damit hat man einen einfachen Überblick was sich verändert hat.
  
 Zusätzlich detektiert der Task ob er auf einem TeamCity-Buildagent 
 ausgeführt wird und produziert automatisch TeamCity Servicemessages,
 welche wiederum für eigene Statistiken in TeamCity verwendet werden
 können.
 
 Oktober 2012, Roland Gisler, Gisler iNFORMATiK
