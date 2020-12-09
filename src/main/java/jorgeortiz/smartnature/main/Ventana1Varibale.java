package jorgeortiz.smartnature.main;

import net.sourceforge.jFuzzyLogic.FIS;

public class Ventana1Varibale extends javax.swing.JFrame{

	private javax.swing.JSlider sldHumedad;
	private net.sourceforge.jFuzzyLogic.FIS FIS;
	private net.sourceforge.jFuzzyLogic.plot.JDialogFis jDialogFis;
	private net.sourceforge.jFuzzyLogic.FunctionBlock functionBlock;

	public Ventana1Varibale(){
		super("JFuzzy Logic");
		
		sldHumedad=new javax.swing.JSlider();
		sldHumedad.setMinimum(0);
		sldHumedad.setMaximum(1023);
		sldHumedad.setMajorTickSpacing(10);
		sldHumedad.setMinorTickSpacing(1);
		sldHumedad.setPaintTicks(true);
		sldHumedad.setPaintLabels(true);
		
		sldHumedad.addChangeListener(new javax.swing.event.ChangeListener(){
			public void stateChanged(javax.swing.event.ChangeEvent c){
				FIS.setVariable("humedadSuelo",new Double(sldHumedad.getValue()).doubleValue());
				FIS.evaluate();
				jDialogFis.repaint();
				
			}
		});
		
		
// 		setLayout(new java.awt.FlowLayout());
		add(sldHumedad);

		setSize(700,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cargarFCL();
	}
	
	private void cargarFCL(){
		FIS=net.sourceforge.jFuzzyLogic.FIS.load("ControlDifuso1Variable.fcl",true);
		jDialogFis=new net.sourceforge.jFuzzyLogic.plot.JDialogFis(FIS);
		sldHumedad.setValue(10);
		System.out.println(sldHumedad.getValue());
		FIS.setVariable("humedadSuelo",new Double(sldHumedad.getValue()));
		FIS.evaluate();
		net.sourceforge.jFuzzyLogic.plot.JFuzzyChart.get().chart(FIS);
		functionBlock=FIS.getFunctionBlock(null);
		double v=functionBlock.getVariable("riego").getLatestDefuzzifiedValue();
		System.out.println("Valor: "+v);
		
		net.sourceforge.jFuzzyLogic.plot.JFuzzyChart.get().chart(functionBlock.getVariable("riego"), functionBlock.getVariable("riego").getDefuzzifier(), true);
	}
	
	public static void main(String [] args){
		new Ventana1Varibale().setVisible(true);
	}
}