
def line = text.getPrecedingLineText();
console.write("Hello World");
String [] macros = line.split(" ");

if (macros.length == 3) {
	String operator = macros[1];
	java.addStaticImport("org.junit.Assert.assertThat");
	text.removePrecedingLineText();
	if (operator == "=") {
	    java.addStaticImport("org.hamcrest.CoreMatchers.equalTo");
	    java.template("assertThat(" + macros[0] + ",equalTo(" + macros[2] + "));");
	} else if (operator == ">") {
	    java.addStaticImport("org.hamcrest.Matchers.greaterThan");
	    java.template("assertThat(" + macros[0] + ",greaterThan(" + macros[2] + "));\${cursor}");
	}
}
