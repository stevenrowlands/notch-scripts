String packageName = java.packageName;
String content =  "package " + packageName + ";"
String className = java.name + "Test";
if (java.name.contains("Test")) {
    javaproject.addFile(java.relativeName.replace("test","src").replace("Test.java", ".java"),content);
    return;
}

content = content + "\n" + "public class " + className + "{\n}";
javaproject.addFile(java.relativeName.replace("src","test").replace(".java", "Test.java"),content);

java.addImport("org.junit.Test");
if (java.getMethod("test") == null) {
	java.addMethod("@Test\npublic void test() {}");
}