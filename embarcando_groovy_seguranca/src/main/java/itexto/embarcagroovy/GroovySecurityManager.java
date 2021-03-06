package itexto.embarcagroovy;

public class GroovySecurityManager extends SecurityManager {
	
	
	
	/**
	 * Verifica se a thread em execução é a que executa os scripts
	 * @return
	 */
	private boolean isScriptThread() {
		String threadName = Thread.currentThread().getName();
		return threadName != null && threadName.equals("ScriptThread");
	}
	
	public void checkFile(final String file) {
		if (isScriptThread()) {
			if (! file.contains("Liberados")) {
				throw new SecurityException("Apenas os liberados podem ser acessados!");
			}
		} 
	}
	
	public void checkWrite(final String file) {
		checkFile(file);
	}
	
	public void checkDelete(final String file) {
		checkFile(file);
	}
	
	public void checkRead(final String file) {
		
	}
	
	
	
	public void checkExit(final int code) {
		super.checkExit(code);
		
		if (isScriptThread())
			throw new SecurityException("Nananinanã! Nem ouse sair da minha JVM meu jovem!");
	}
	
	
	
}
