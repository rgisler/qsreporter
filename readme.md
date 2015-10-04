### QS-Reporter
 
Ant-Task mit welchem die Ergebnisse (Summen) von 
 
 * Checkstyle
 * Classycle
 * PMD
 * JaCoCo (eclemma, Coverage)

aus deren XML-Reports gelesen und auf der Konsole ausgegeben werden.
Damit hat man einen einfachen Überblick was sich verändert hat.
  
Zusätzlich detektiert der Task ob er auf einem TeamCity-Buildagent 
ausgeführt wird und produziert automatisch TeamCity Servicemessages,
welche wiederum für eigene Statistiken in TeamCity verwendet werden
können.

| Branch | Travis-CI | Snap-CI |
|:-------|-----------|--------:|
| develop | [![Build Status](https://travis-ci.org/rgisler/qsreporter.png?branch=develop)](https://travis-ci.org/rgisler/qsreporter) | |
| master | [![Build Status](https://travis-ci.org/rgisler/qsreporter.png?branch=develop)](https://travis-ci.org/rgisler/qsreporter) | [![Build Status](https://snap-ci.com/rgisler/qsreporter/branch/master/build_image)](https://snap-ci.com/rgisler/qsreporter/branch/master) |
Vollständige Dokumentation siehe http://rgisler.github.io/qsreporter/
 
Januar 2015, Roland Gisler, Gisler iNFORMATiK
