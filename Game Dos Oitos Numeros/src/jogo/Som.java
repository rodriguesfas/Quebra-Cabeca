/**
 *  Este programa é software livre; você pode redistribuí-lo e/ou
 *  modificá-lo sob os termos da Licença Pública Geral GNU, conforme
 *  publicada pela Free Software Foundation; tanto a versão 2 da
 *  Licença como (a seu critério) qualquer versão mais nova.
 *
 *  Este programa é distribuído na expectativa de ser útil, mas SEM
 *  QUALQUER GARANTIA; sem mesmo a garantia implícita de
 *  COMERCIALIZAÇÃO ou de ADEQUAÇÃO A QUALQUER PROPÓSITO EM
 *  PARTICULAR. Consulte a Licença Pública Geral GNU para obter mais
 *  detalhes.
 *
 *  Você deve ter recebido uma cópia da Licença Pública Geral GNU
 *  junto com este programa; se não, escreva para a Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 *  02111-1307, USA.
 * 
 *  @author Francisco de Assis de Souza Rodrigues (2013)
 *  
 */
package jogo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;

public class Som {

	public void main(String[] args) {

		// String com o caminho do arquivo MP3 a ser tocado
		String path = "res/som/toque.mp3";

		// Instanciação de um objeto File com o arquivo MP3
		File mp3File = new File(path);

		// Instanciação do Objeto MP3Som.
		MP3Som toque = new MP3Som();
		toque.tocarSom(mp3File);

		// Finalmente a chamada do método que toca a música
		toque.start();
	}

	/**
	 * ====================================================================
	 * ====================================CLASS INTERNA MP3Som
	 * ====================================================================
	 */
	public static class MP3Som extends Thread {

		// Objeto para nosso arquivo MP3 a ser tocado
		private File mp3;

		// Objeto Player da biblioteca jLayer. Ele tocará o arquivo MP3
		private Player player;

		/*
		 * Construtor que recebe o objeto File referenciando o arquivo MP3 a ser
		 * tocado e atribui ao atributo MP3 da classe.
		 * 
		 * @param mp3
		 */
		public void tocarSom(File mp3) {
			this.mp3 = mp3;
		}

		/*
		 * ==================================================================
		 * =============================================METODO QUE TOCA O MP3
		 * ==================================================================
		 */
		public void run() {
			try {
				FileInputStream fis = new FileInputStream(mp3);

				BufferedInputStream bis = new BufferedInputStream(fis);

				this.player = new Player(bis);

				this.player.play();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Problema ao tocar Som!"
						+ mp3);
				e.printStackTrace();
			}
		}

	}

}