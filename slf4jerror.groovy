java.addImport("org.slf4j.Logger");
java.addImport("org.slf4j.LoggerFactory");
java.addFieldFirst("private static final Logger LOGGER = LoggerFactory.getLogger(" + java.className +");");
java.template("LOGGER.error(\"\${msg}\", \${t:var(java.lang.Throwable)});");