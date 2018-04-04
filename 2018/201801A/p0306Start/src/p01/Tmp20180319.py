'''
This is a test script. 
'''
print("Hello");
msg = 'Hello'
if msg == 'Hello':
    print('This is ' + msg);
else:
    print('this is others')
print("end");

def fun(arg1,arg2):
    print("arg1:"+str(arg1)+",arg2:"+str(arg2));
    return arg1+arg2;

print(fun(1,2));
print(fun('Hello ','World'));
    
