#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=base.app.portal.dashboard/target/base.app.portal.dashboard-1.3.0-SNAPSHOT.jar:base.app.portal.dashboard/target/dependency/*;

#REM call the java VM, e.g, 
java -cp %BASE_CP% eapli.base.app.portal.presentation.BasePortal
