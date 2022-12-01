package tile;
import java.io.BufferedReader;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

import javax.imageio.ImageIO;

import main.UtilityTool;
import main.panelGame;

public class TileManager {

	panelGame gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(panelGame gp) {
		this.gp = gp;
		
		tile = new Tile[1000];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map50.txt");
	}
	
	public void getTileImage() {

		setup(0, "000", false);
		setup(1, "001", false);
		setup(2, "002", false);
		setup(3, "003", false);
		setup(4, "004", false);
		setup(5, "005", false);
		setup(6, "006", false);
		setup(7, "007", false);
		setup(8, "008", false);
		setup(9, "009", false);
		setup(10, "010", false);
		setup(11, "011", false);
		setup(12, "012", false);
		setup(13, "013", false);
		setup(14, "014", false);
		setup(15, "015", false);
		setup(16, "016", true);
		setup(17, "017", false);
		setup(18, "018", true);
		setup(19, "019", true);
		setup(20, "020", true);
		setup(21, "021", true);
		setup(22, "022", true);
		setup(23, "023", true);
		setup(24, "024", true);
		setup(25, "025", true);
		setup(26, "026", true);
		setup(27, "027", true);
		setup(28, "028", true);
		setup(29, "029", true);
		setup(30, "030", true);
		setup(31, "031", true);
		setup(32, "032", true);
		setup(33, "033", true);
		setup(34, "034", false);
		setup(35, "035", true);
		setup(36, "036", true);
		setup(37, "037", true);
		setup(38, "038", true);
		setup(39, "039", false);
		setup(40, "040", false);
		setup(41, "041", true);
		setup(42, "042", false);
		setup(43, "043", false);
		setup(44, "044", false);
		setup(45, "045", false);
		setup(46, "046", false);
		setup(47, "047", false);
		setup(48, "048", false);
		setup(49, "049", false);
		setup(50, "050", false);
		setup(51, "051", false);
		setup(52, "052", false);
		setup(53, "053", false);
		setup(54, "054", false);
		setup(55, "055", false);
		setup(56, "056", false);
		setup(57, "057", false);
		setup(58, "058", false);
		setup(59, "059", false);
		setup(60, "060", true);
		setup(61, "061", true);
		setup(62, "062", true);
		setup(63, "063", true);
		setup(64, "064", true);
		setup(65, "065", true);
		setup(66, "066", true);
		setup(67, "067", true);
		setup(68, "068", true);
		setup(69, "069", true);
		setup(70, "070", true);
		setup(71, "071", true);
		setup(72, "072", false);
		setup(73, "073", true);
		setup(74, "074", true);
		setup(75, "075", false);
		setup(76, "076", false);
		setup(77, "077", false);
		setup(78, "078", true);
		setup(79, "079", true);
		setup(80, "080", true);
		setup(81, "081", true);
		setup(82, "082", true);
		setup(83, "083", true);
		setup(84, "084", true);
		setup(85, "085", true);
		setup(86, "086", true);
		setup(87, "087", true);
		setup(88, "088", true);
		setup(89, "089", true);
		setup(90, "090", true);
		setup(91, "091", true);
		//setup(92, "092", false);
		
	}
	
	
	public void setup(int index, String imagePath, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagePath + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tilesize, gp.tilesize);
			tile[index].collision = collision;
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void loadMap(String mapPath) {
		try {
			InputStream is= getClass().getResourceAsStream(mapPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
					
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
					
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
					
			br.close();		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tilesize;
			int worldY = worldRow * gp.tilesize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tilesize > gp.player.worldX - gp.player.screenX && 
					worldX - gp.tilesize < gp.player.worldX + gp.player.screenX && 
					worldY + gp.tilesize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tilesize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
				
			}
			
			worldCol++;
			
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0; 
				worldRow++;

			}
		}
		
		
		
	}
}
