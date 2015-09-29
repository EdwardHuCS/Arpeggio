import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class JUARPEGGIOTest {

	private Game g;
	private Armor arm = new Armor("Manboobs", 101010);
	private Weapon weap = new Weapon("Green Gun", 101010);
	private Protagonist p = new Protagonist("Billy");
	private Item i;
	private Inventory inv = new Inventory();
	private story1  stor = new story1();

	/****************************************** Game.class tests *******************************************************************/
	@Test
	public void testGameConstructor() {
		g = new Game();
		assertNotNull(g);
	}

	@Test
	public void testNewGame() {
		g = new Game();
		g.newGame();
		assertTrue(g.test.equals("hi"));
	}

	@Test
	public void testLoadLoot() {
		g = new Game();
		weap = Game.weapList.get("Green Gun");
		assertNotNull(weap);
		
	}
	
	/*******************************************Armor.class tests*************************************************************/
	
	
	
	@Test
	public void testArmorConstructor()
	{
		Armor a = new Armor("blah", 100000);
		assertNotNull(a);
	}
	
	@Test
	public void testArmorGetName()
	{
		assertTrue(arm.getArmorName().equals("Manboobs"));
	}
	
	@Test
	public void testArmorGetStat()
	{
		assertEquals(arm.getArmorStat(), 101010);
	}
	
	@Test
	public void testArmorGetElement()
	{
		assertEquals(arm.getArmorElement(), 1);
	}
	
	@Test
	public void testArmorGetStaticBlock()
	{
		assertEquals(arm.getStaticBlock(), 10);
	}
	
	@Test
	public void testArmorGetPercBlock()
	{
		assertEquals(arm.getPercBlock(), 10, 0.1);
	}
	
	@Test
	public void testArmorAddDefStat()
	{
		arm.addDefStat(10);
		assertEquals(arm.getArmorStat(), 102015);
	}
	
	@Test
	public void testArmorMitigate()
	{
		double d = arm.mitigate(100.0);
		assertEquals(d, 81, 0.1);
	}
	
	@Test
	public void testArmorEquals()
	{
		Armor arm2 = new Armor("Manboobs", 101010);
		assertTrue(arm2.equals(arm));
	}
	
	@Test
	public void testArmorToString()
	{
		assertNotNull(arm.toString());
	}
	
	/*******************************************Weapon.class tests*********************************************/
	@Test
	public void testWeaponConstructor()
	{
		Weapon a = new Weapon("blah", 100000);
		assertNotNull(a);
	}
	
	@Test
	public void testWeaponGetName()
	{
		assertEquals(weap.getWeaponName(), "Green Gun");
	}
	
	@Test
	public void testWeaponGetStat()
	{
		assertEquals(weap.getWeaponStat(), 101010);
	}
	
	@Test
	public void testWeaponGetElement()
	{
		assertEquals(weap.getWeaponElement(), 1);
	}
	
	@Test
	public void testWeaponGetHitChance()
	{
		assertEquals(weap.getWeaponHitChance(), 10, 0.1);
	}
	
	@Test
	public void testWeaponEquals()
	{
		assertTrue(weap.equals(new Weapon("Green Gun", 101010)));
	}
	
	@Test
	public void testWeaponGetWeaponDamage()
	{
		assertEquals(weap.getWeaponDamage(), 10, 0.1);
	}
	
	@Test
	public void testWeaponToString()
	{
		String s = weap.toString();
		assertNotNull(s);
	}
	
	
	/*****************************************Protagonist.class tests*****************************************/
	
	@Test
	public void testProConstructor()
	{
		Protagonist d = new Protagonist("hubba");
		assertNotNull(d);
	}
	
	@Test
	public void testProPlayerClass()
	{
		assertEquals(p.getPlayerClass(), 0);
		p.setPlayerClass(1);
		assertEquals(p.getPlayerClass(), 1);
	}
	
	@Test
	public void testProArmor()
	{
		assertNull(p.getMyArmor());
		p.setMyArmor(arm);
		assertEquals(p.getMyArmor(), arm);
	}
	
	@Test
	public void testProWeapon()
	{
		assertNull(p.getMyWeapon());
		p.setMyWeapon(weap);
		assertEquals(p.getMyWeapon(), weap);
	}
	
	@Test
	public void testProName()
	{
		assertEquals(p.getMyName(), "Billy");
		p.setMyName("Bob");
		assertEquals(p.getMyName(), "Bob");
	}
	
	@Test
	public void testProExperience()
	{
		assertTrue(p.getExperience() == 0);
		p.addExp(5);
		assertTrue(p.getExperience() == 1);
	}
	
	@Test
	public void testProStats()
	{
		for(int i = 0; i < p.getStatArray().length; i++)
		{
			assertNotNull(p.getStatArray()[i]);
		}
	}
	
	@Test
	public void testProIsLvlUp()
	{
		for(int i = 1; i <= 100; i++)
		{
			p.addExp(5);
		}
		assertTrue(p.isLvlUp());
	}
	
/*******************************************************************Inventory.class tests*****************************************************************/
	
	@Test
	public void testInvConstructor()
	{
		assertNotNull(inv);
	}
	
	@Test
	public void testInvGetters()
	{
		assertTrue(inv.getWeapons().isEmpty());
		inv.getWeapons().add(Game.weapList.get("Green Gun"));
		assertTrue(inv.getWeapons().size() == 1);
	}
	
	@Test
	public void testInvFinders()
	{
		inv.getWeapons().add(Game.weapList.get("Green Gun"));
		Weapon w = inv.findWeapon("Green Gun");
		assertEquals(w, Game.weapList.get("Green Gun"));
		w = inv.findWeapon("blahblah");
		assertNull(w);
	}
	
	/***************************************************story1.class tests****************************************/
	
	@Test
	public void testStory1Constructor()
	{
		assertNotNull(stor.getWeaknessStickFactor());
		assertTrue(stor.getWeaknessStickFactor() < 20 && stor.getWeaknessStickFactor() >= 0);
	}

	

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(JUARPEGGIOTest.class);
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("JUARPEGGIOTest");
	}

}
