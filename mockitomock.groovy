java.addStaticImport("org.mockito.Mockito.*");

//java.template("\${Type} \${varName} = mock(\${Type}.class);");


java.template("\${Type} \${cursor}", {
	text.addText(Type.toLowerCase() + " = mock(" + Type + ".class);");
});