#Use of nut java parser

There is two step to launch the project : 
- makefile (do make and follow instruction)
- gradle (follow below steps)

##Makefile
You need to have gradle to develop the nut java parser. 

So, you can install grable by doing 'make gradle'.

Next, all makefile command are same as gradle command. 

##Gradle
If you don't have gradle, do 'make gradle' and it will be setup.

Else, you can do 'gradle tasks' to view all command, and all possibilities of gradle.

All that you need are :
- All the documentation is generated in docs folder.
- All binaries are in build foler

If you want to test a class :
- create a class in test/test folder
- write your method that will test the class (be aware that this method can't have any argument, and it can't be static), notice '@Test' above it and import 'org.junit.*', such as :
```
import org.junit.*;

public class TestNut{

    @Test
    public void main() {
        Assert.assertEquals("must return 0",Nut.main(new String[0]),0);
    }

}
```
- when you write your test, think that the test/test folder is the src/ folder. For exemple, we have next organisation of folder :

```
.
├── docs
├── build
│   └── ...
├── gradle
│   └── ...
├── resource
│   └── ...
├── src
│   └── Nut.java
├── test
│   ├── test
│   │   └── TestNut.java
│   └── resource
└── README.md
```
When you code in TestNut.java file, think that TestNut.java file is in the same folder that Nut.java file.

- when you lanch 'gradle test', you have a log test file (.html) in 'build/reports/tests/test/index.html' page.

