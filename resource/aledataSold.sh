#!/bin/sh
cat aledataMnS_Sold.txt | ./alexml.sh | ./alepost.sh -h lt.mns.vizixcloud.com -p 9090

