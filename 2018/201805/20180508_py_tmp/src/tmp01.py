'''
Created on May 8, 2018

@author: Admin
'''
import re;

line="Hello Tom";

print(line);

regexStr="^H"
if re.match(regexStr, line):
    print("1.re.match(regexStr, line)");
else:
    print("1. not matched")
print("End");
    
    