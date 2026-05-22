package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO extends DAO {

	public List<Product> searchAndSort(String sortOrder) throws Exception {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();

		// ベースとなるSQL文（全件取得）
		String sql = "select * from product";

		// パラメータ（high / low）に応じて SQL に ORDER BY を追加
		if ("high".equals(sortOrder)) {
			sql += " order by price desc"; // 価格が高い順（降順）
		} else if ("low".equals(sortOrder)) {
			sql += " order by price asc";  // 価格が安い順（昇順）
		}

		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

}

