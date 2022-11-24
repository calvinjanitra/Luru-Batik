package tile;
import java.io.BufferedReader;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import javax.imageio.ImageIO;

import main.panelGame;

public class TileManager {

	panelGame gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(panelGame gp) {
		this.gp = gp;
		
		tile = new Tile[80];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map50.txt");
	}
	
	public void getTileImage() {

		try {
				
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/000.png"));
			tile[0].collision = true;
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/001.png"));
			tile[1].collision = false;
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/002.png"));
			tile[2].collision = false;
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/003.png"));
			tile[3].collision = false;
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/004.png"));
			tile[4].collision = false;
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/005.png"));
			tile[5].collision = false;
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/006.png"));
			tile[6].collision = false;
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/007.png"));
			tile[7].collision = false;
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/008.png"));
			tile[8].collision = false;
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/009.png"));
			tile[9].collision = false;
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/010.png"));
			tile[10].collision = false;
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/011.png"));
			tile[11].collision = false;
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/012.png"));
			tile[12].collision = false;
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/013.png"));
			tile[13].collision = false;
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/014.png"));
			tile[14].collision = false;
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/015.png"));
			tile[15].collision = false;
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/016.png"));
			tile[16].collision = true;
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/017.png"));
			tile[17].collision = false;
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/018.png"));
			tile[18].collision = true;
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/019.png"));
			tile[19].collision = true;
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/020.png"));
			tile[20].collision = true;
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/021.png"));
			tile[21].collision = true;
			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/022.png"));
			tile[22].collision = true;
			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/023.png"));
			tile[23].collision = true;
			
			tile[24] = new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/024.png"));
			tile[24].collision = true;
			tile[25] = new Tile();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/025.png"));
			tile[25].collision = true;
			tile[26] = new Tile();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/026.png"));
			tile[26].collision = true;
			tile[27] = new Tile();
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/027.png"));
			tile[27].collision = true;
			tile[28] = new Tile();
			tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/028.png"));
			tile[28].collision = true;
			tile[29] = new Tile();
			tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/029.png"));
			tile[29].collision = true;
			tile[30] = new Tile();
			tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/030.png"));
			tile[30].collision = true;
			tile[31] = new Tile();
			tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/031.png"));
			tile[31].collision = true;
			tile[32] = new Tile();
			tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/032.png"));
			tile[32].collision = true;
			tile[33] = new Tile();
			tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/033.png"));
			tile[33].collision = false;
			tile[34] = new Tile();
			tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/034.png"));
			tile[34].collision = false;
			tile[35] = new Tile();
			tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/035.png"));
			tile[35].collision = true;
			tile[36] = new Tile();
			tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/036.png"));
			tile[36].collision = false;
			tile[37] = new Tile();
			tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/037.png"));
			tile[37].collision = false;
			tile[38] = new Tile();
			tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/038.png"));
			tile[38].collision = true;
			tile[39] = new Tile();
			tile[39].image = ImageIO.read(getClass().getResourceAsStream("/tiles/039.png"));
			tile[39].collision = false;
			tile[40] = new Tile();
			tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/040.png"));
			tile[40].collision = false;
			tile[41] = new Tile();
			tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/041.png"));
			tile[41].collision = false;
			tile[42] = new Tile();
			tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/042.png"));
			tile[42].collision = false;
			tile[43] = new Tile();
			tile[43].image = ImageIO.read(getClass().getResourceAsStream("/tiles/043.png"));
			tile[43].collision = false;
			tile[44] = new Tile();
			tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/044.png"));
			tile[44].collision = false;
			tile[45] = new Tile();
			tile[45].image = ImageIO.read(getClass().getResourceAsStream("/tiles/045.png"));
			tile[45].collision = false;
			tile[46] = new Tile();
			tile[46].image = ImageIO.read(getClass().getResourceAsStream("/tiles/046.png"));
			tile[46].collision = false;
			tile[47] = new Tile();
			tile[47].image = ImageIO.read(getClass().getResourceAsStream("/tiles/047.png"));
			tile[47].collision = false;
			tile[48] = new Tile();
			tile[48].image = ImageIO.read(getClass().getResourceAsStream("/tiles/048.png"));
			tile[48].collision = false;
			tile[49] = new Tile();
			tile[49].image = ImageIO.read(getClass().getResourceAsStream("/tiles/049.png"));
			tile[49].collision = false;
			tile[50] = new Tile();
			tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/050.png"));
			tile[50].collision = false;
			tile[51] = new Tile();
			tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/051.png"));
			tile[51].collision = false;
			tile[52] = new Tile();
			tile[52].image = ImageIO.read(getClass().getResourceAsStream("/tiles/052.png"));
			tile[52].collision = false;
			tile[53] = new Tile();
			tile[53].image = ImageIO.read(getClass().getResourceAsStream("/tiles/053.png"));
			tile[53].collision = false;
			tile[54] = new Tile();
			tile[54].image = ImageIO.read(getClass().getResourceAsStream("/tiles/054.png"));
			tile[54].collision = false;
			tile[55] = new Tile();
			tile[55].image = ImageIO.read(getClass().getResourceAsStream("/tiles/055.png"));
			tile[55].collision = false;
			tile[56] = new Tile();
			tile[56].image = ImageIO.read(getClass().getResourceAsStream("/tiles/056.png"));
			tile[56].collision = false;
			tile[57] = new Tile();
			tile[57].image = ImageIO.read(getClass().getResourceAsStream("/tiles/057.png"));
			tile[57].collision = false;
			tile[58] = new Tile();
			tile[58].image = ImageIO.read(getClass().getResourceAsStream("/tiles/058.png"));
			tile[58].collision = false;
			tile[59] = new Tile();
			tile[59].image = ImageIO.read(getClass().getResourceAsStream("/tiles/059.png"));
			tile[59].collision = false;
			tile[60] = new Tile();
			tile[60].image = ImageIO.read(getClass().getResourceAsStream("/tiles/060.png"));
			tile[60].collision = false;
			tile[61] = new Tile();
			tile[61].image = ImageIO.read(getClass().getResourceAsStream("/tiles/061.png"));
			tile[61].collision = false;
			tile[62] = new Tile();
			tile[62].image = ImageIO.read(getClass().getResourceAsStream("/tiles/062.png"));
			tile[62].collision = false;
			tile[63] = new Tile();
			tile[63].image = ImageIO.read(getClass().getResourceAsStream("/tiles/063.png"));
			tile[63].collision = false;
			tile[64] = new Tile();
			tile[64].image = ImageIO.read(getClass().getResourceAsStream("/tiles/064.png"));
			tile[64].collision = false;
			tile[65] = new Tile();
			tile[65].image = ImageIO.read(getClass().getResourceAsStream("/tiles/065.png"));
			tile[65].collision = false;
			tile[66] = new Tile();
			tile[66].image = ImageIO.read(getClass().getResourceAsStream("/tiles/066.png"));
			tile[66].collision = false;
			tile[67] = new Tile();
			tile[67].image = ImageIO.read(getClass().getResourceAsStream("/tiles/067.png"));
			tile[67].collision = false;
			tile[68] = new Tile();
			tile[68].image = ImageIO.read(getClass().getResourceAsStream("/tiles/068.png"));
			tile[68].collision = false;
			tile[69] = new Tile();
			tile[69].image = ImageIO.read(getClass().getResourceAsStream("/tiles/069.png"));
			tile[69].collision = false;
			tile[70] = new Tile();
			tile[70].image = ImageIO.read(getClass().getResourceAsStream("/tiles/070.png"));
			tile[70].collision = false;
			
			tile[71] = new Tile();
			tile[71].image = ImageIO.read(getClass().getResourceAsStream("/tiles/071.png"));
			tile[71].collision = false;
			tile[72] = new Tile();
			tile[72].image = ImageIO.read(getClass().getResourceAsStream("/tiles/072.png"));
			tile[72].collision = false;
			tile[73] = new Tile();
			tile[73].image = ImageIO.read(getClass().getResourceAsStream("/tiles/073.png"));
			tile[73].collision = false;
			tile[74] = new Tile();
			tile[74].image = ImageIO.read(getClass().getResourceAsStream("/tiles/074.png"));
			tile[74].collision = false;

			
			
			
			
		}catch (IOException e) {
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
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tilesize, gp.tilesize, null);
				
			}
			
			worldCol++;
			
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0; 
				worldRow++;

			}
		}
		
		
		
	}
}
