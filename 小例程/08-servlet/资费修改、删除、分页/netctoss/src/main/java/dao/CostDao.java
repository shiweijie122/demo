package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cost;
import util.DBUtil;

public class CostDao {

	public List<Cost> findAll() {
		Connection con = null;
		try {
			//��������
			con = DBUtil.getConnection();
			//��ѯSQL
			String sql = "select * from cost order by cost_id";
			//����SQL
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//ִ�в�ѯ
			ResultSet rs = ps.executeQuery();
			//��������
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			//��¼��־
			e.printStackTrace();
			//�����׳�
			throw new RuntimeException(
				"��ѯ�ʷ�ʧ��", e);
		} finally {
			//�黹����
			DBUtil.close(con);
		}
	}

	/**
	 * Alt+Shift+M
	 */
	private Cost createCost(ResultSet rs) 
		throws SQLException {
		Cost c = new Cost();
		c.setCostId(rs.getInt("cost_id"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("base_duration"));
		c.setBaseCost(rs.getDouble("base_cost"));
		c.setUnitCost(rs.getDouble("unit_cost"));
		c.setStatus(rs.getString("status"));
		c.setDescr(rs.getString("descr"));
		c.setCreatime(rs.getTimestamp("creatime"));
		c.setStartime(rs.getTimestamp("startime"));
		c.setCostType(rs.getString("cost_type"));
		return c;
	}
	
	public void save(Cost cost) {
		if(cost == null)
			return;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"insert into cost " +
				"values(cost_seq.nextval," +
				"?,?,?,?,'0',?,sysdate,null,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"�����ʷ�ʧ��");
		} finally {
			DBUtil.close(con);
		}
	}
	
	public Cost findById(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from cost where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return createCost(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"����ID��ѯ�ʷ�ʧ��");
		} finally {
			DBUtil.close(con);
		}
		return null;
	}
	
	public void update(Cost cost) {
		if(cost == null)
			return;
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"update cost set " +
				"	name=?," +
				"	base_duration=?," +
				"	base_cost=?," +
				"	unit_cost=?," +
				"	descr=?," +
				"	cost_type=? " +
				"where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, cost.getName());
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.setInt(7, cost.getCostId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"�޸��ʷ�ʧ��");
		} finally {
			DBUtil.close(con);
		}
	}
	
	public void delete(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "delete from cost where cost_id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
				"ɾ���ʷ�ʧ��");
		} finally {
			DBUtil.close(con);
		}
	}
	
	public List<Cost> findByPage(
			int page, int size) {
			Connection con = null;
			try {
				con = DBUtil.getConnection();
				String sql = 
					"select * from ("
					+ "	select c.*,rownum r from ("
					+ "	  select * from cost "
					+ "	  order by cost_id"
					+ " ) c"
					+ ") where r between ? and ?";
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ps.setInt(1, (page-1)*size+1);
				ps.setInt(2, page*size);
				ResultSet rs = ps.executeQuery();
				List<Cost> list = new ArrayList<Cost>();
				while(rs.next()) {
					Cost c = createCost(rs);
					list.add(c);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(
					"��ҳ��ѯ�ʷ�ʧ��", e);
			} finally {
				DBUtil.close(con);
			}
		}
		
		/**
		 * ��ѯ������
		 */
		public int findRows() {
			Connection con = null;
			try {
				con = DBUtil.getConnection();
				String sql = 
					"select count(*) from cost";
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(
					"��ѯ������ʧ��", e);
			} finally {
				DBUtil.close(con);
			}
			return 0;
		}
	
}







