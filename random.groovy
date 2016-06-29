

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageDeclaration;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.SourceRange;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NodeFinder;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.internal.corext.ValidateEditException;
import org.eclipse.jdt.internal.corext.codemanipulation.AddGetterSetterOperation;
import org.eclipse.jdt.internal.corext.codemanipulation.CodeGenerationSettings;
import org.eclipse.jdt.internal.corext.codemanipulation.StubUtility;
import org.eclipse.jdt.internal.corext.dom.ASTNodes;
import org.eclipse.jdt.internal.corext.util.CodeFormatterUtil;
import org.eclipse.jdt.internal.corext.util.JavaModelUtil;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.preferences.JavaPreferencesSettings;
import org.eclipse.jdt.internal.ui.util.BusyIndicatorRunnableContext;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.templates.TemplateBuffer;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import rowley.eclipse.notch.bindings.java.*;

import groovy.lang.Closure;

//java.nearestElement;
java.addStaticImport("org.mockito.Mockito.*"); 
TextSelection textSelection = (TextSelection) editor.getSelectionProvider().getSelection();
		ASTSupport astSupport = new ASTSupport();

		CompilationUnit astRoot = astSupport.parse(getUnit());
		ASTNode nearest = NodeFinder.perform(astRoot, new SourceRange(textSelection.getOffset(), textSelection.getLength()));
		if (nearest instanceof ClassInstanceCreation) {
			ClassInstanceCreation instance = (ClassInstanceCreation)nearest;

			ASTRewrite astRewrite = ASTRewrite.create(nearest.getAST());
			ListRewrite rewrite = astRewrite.getListRewrite(nearest, ClassInstanceCreation.ARGUMENTS_PROPERTY);
			
			for (IMethodBinding binding : instance.getType().resolveBinding().getDeclaredMethods()) {
				//binding.getJavaElement();
				if (binding.isConstructor()) {
					for (ITypeBinding type : binding.getMethodDeclaration().getParameterTypes()) {
						ASTNode node1 = astSupport.parseNode("mock(" + type.getName() + ".class)");
						rewrite.insertLast(node1, null);
					}
				}
				
			}
			instance.getStructuralProperty(((ClassInstanceCreation) nearest).ARGUMENTS_PROPERTY);
			ASTNodes.getChildren(instance);
			TextEdit edit = astRewrite.rewriteAST();
				JavaModelUtil.applyEdit(getUnit(), edit, false, null);
	

		}
		return null;


	private CompilationUnitEditor getEditor() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage activePage = activeWindow.getActivePage();
		IEditorPart editor = activePage.getActiveEditor();
		return (CompilationUnitEditor) editor;
	}

	private ICompilationUnit getUnit() {
		return (ICompilationUnit) getEditor().getViewPartInput();
	}
