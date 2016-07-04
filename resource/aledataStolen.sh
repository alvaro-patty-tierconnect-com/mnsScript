#!/bin/sh
cat aledataMnS_Stolen.txt | ./alexml.sh | ./alepost.sh -h lt.mns.vizixcloud.com -p 9090

