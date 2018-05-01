package Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import Logic.Calculation;

public class Main {
	public static String first;
	public static String second;
	public static String res;
	public static Display display = new Display();
	public static Shell shell = new Shell(display);
	static Text first_lbl = new Text(shell, SWT.BORDER);
	static Text second_lbl = new Text(shell, SWT.BORDER);
	static Button btn = new Button(shell, SWT.PUSH);
	static Text result_lbl = new Text(shell, SWT.BORDER);
	public static void main(String[] args) {
		
		shell.setLayout(new GridLayout(2, false));
		
	    
	    btn.setText("Click me");
	    btn.addSelectionListener(new SelectionAdapter() {
	        @Override
	        public void widgetSelected(SelectionEvent e) {
	            super.widgetSelected(e);
	            Calculation calc = new Calculation();
	            res = calc.startCulc(first_lbl.getText().toString(), second_lbl.getText().toString());
	            result_lbl.setText(res);
	        }
	    });
	    shell.setSize(400, 400);
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	  }
	}

