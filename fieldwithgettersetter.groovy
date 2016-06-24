java.template("private \${Type} \${var};", {
	java.addMethod("public void set" + var.substring(0,1).toUpperCase() + var.substring(1) + "(" + Type + " " + var +") { this." + var + "=" + var + "; }")
	java.addMethod("public " + Type + " get" + var.substring(0,1).toUpperCase() + var.substring(1) + "() { return this." + var + ";}")
});
