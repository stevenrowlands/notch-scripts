String packageName = java.packageName;
String content =  "package " + packageName + ";"
String className = java.name + "Test";
console.write(java.relativeName);
if (java.relativeName.contains("src/test/java")) {
    javaproject.addFile(java.relativeName.replace("src/test/java","src/main/java").replace("Test.java", ".java"),content);
    return;
} else if (java.relativeName.contains("Test.java")) {
    javaproject.addFile(java.relativeName.replace("test","src").replace("Test.java", ".java"),content);
    return;
}

content = content + "\n" + "public class " + className + "{\n}";
if (java.relativeName.contains("src/main/java")) {
 javaproject.addFile(java.relativeName.replace("src/main/java","src/test/java").replace(".java", "Test.java"),content);
} else {
 javaproject.addFile(java.relativeName.replace("src","test").replace(".java", "Test.java"),content);
}

java.addImport("org.junit.Test");