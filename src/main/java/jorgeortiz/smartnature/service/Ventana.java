package jorgeortiz.smartnature.service;

import net.sourceforge.jFuzzyLogic.FIS;

public class Ventana extends javax.swing.JFrame{

	private javax.swing.JSlider sldCalor;
	private net.sourceforge.jFuzzyLogic.FIS FIS;
	private net.sourceforge.jFuzzyLogic.plot.JDialogFis jDialogFis;
	private net.sourceforge.jFuzzyLogic.FunctionBlock functionBlock;

	public Ventana(){
		super("JFuzzy Logic");
		
		sldCalor=new javax.swing.JSlider();
		sldCalor.setMinimum(0);
		sldCalor.setMaximum(150);
		sldCalor.setMajorTickSpacing(10);
		sldCalor.setMinorTickSpacing(1);
		sldCalor.setPaintTicks(true);
		sldCalor.setPaintLabels(true);
		
		sldCalor.addChangeListener(new javax.swing.event.ChangeListener(){
			public void stateChanged(javax.swing.event.ChangeEvent c){
				FIS.setVariable("calor",new Double(sldCalor.getValue()/10.0).doubleValue());
				FIS.evaluate();
				jDialogFis.repaint();
				
			}
		});
// 		setLayout(new java.awt.FlowLayout());
		add(sldCalor);

		setSize(700,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cargarFCL();
	}
	
	private void cargarFCL(){
		FIS=net.sourceforge.jFuzzyLogic.FIS.load("ControlDifuso.fcl",true);
		jDialogFis=new net.sourceforge.jFuzzyLogic.plot.JDialogFis(FIS);
		FIS.setVariable("calor",new Double(sldCalor.getValue()/10.0));
		FIS.evaluate();
		net.sourceforge.jFuzzyLogic.plot.JFuzzyChart.get().chart(FIS);
		functionBlock=FIS.getFunctionBlock(null);
		double v=functionBlock.getVariable("velocidad").getLatestDefuzzifiedValue();
		System.out.println("Valor: "+v);
		
		net.sourceforge.jFuzzyLogic.plot.JFuzzyChart.get().chart(functionBlock.getVariable("velocidad"), functionBlock.getVariable("velocidad").getDefuzzifier(), true);
	}
	
	public static void main(String [] args){
		new Ventana().setVisible(true);
	}
}