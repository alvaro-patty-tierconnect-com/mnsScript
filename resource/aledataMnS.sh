#!/bin/sh
cat aledata.txt | ./alexml.sh | ./alepost.sh -h lt.mns.vizixcloud.com -p 9090


