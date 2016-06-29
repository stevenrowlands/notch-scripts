
def line = text.getPrecedingLineText();

String [] macros = line.split(" ");
if (macros[1] == "=") {
    text.removePrecedingLineText();
    java.addStaticImport("org.junit.Assert.assertThat");
    java.addStaticImport("org.hamcrest.CoreMatchers.equalTo");
    java.template("assertThat(" + macros[0] + ",equalTo(" + macros[2] + "));");
} else if (macros[1] == ">") {
    text.removePrecedingLineText();
    java.addStaticImport("org.junit.Assert.assertThat");
    java.addStaticImport("org.hamcrest.Matchers.greaterThan");
    java.template("assertThat(" + macros[0] + ",greaterThan(" + macros[2] + "));\${cursor}");
}
