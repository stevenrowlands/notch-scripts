import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.ide.IDE;
import java.net.URL;

java.template("do you like cats? \${yes}", {
        text.removePrecedingLineText();
        if (yes.equals("yes")) {
	    final IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser("cats");
	    browser.openURL(new URL("http://thecatapi.com/"));
	} else {
	    final IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser("cats");
	    browser.openURL(new URL("http://thecatapi.com/"));
	}
});


			