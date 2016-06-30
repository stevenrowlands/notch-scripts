
def line = text.getPrecedingLineText();
java.template("please enter your name \${name}", {
    text.removePrecedingLineText();
    java.template("hello " + name + " do you like eclipse \${yes}\${cursor}", {
        text.removePrecedingLineText();
        if (yes.equals("yes")) {
	    text.addText("of course you do");
	} else {
	    text.addText("outrageous!");
	}
    });
});
