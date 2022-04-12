package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MySQLDB2 {
	public void insert( String mID, String mPW) {
        Connection conn= null;
        PreparedStatement pstmt = null;
        
        String dbURL = "jdbc:mysql://127.0.0.1:3306/swingDB?useSSL=false";
        String dbID = "root";
        String dbPW = "rootroot";
        
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(dbURL, dbID, dbPW);
           
           String sql = "insert into memberLoginTBL(mID, mPW ) "
                 + " values ( ?, ?)";
           pstmt = conn.prepareStatement(sql);
          
           pstmt.setString(1, mID);
           pstmt.setString(2, mPW);
           pstmt.executeUpdate();
           
           System.out.println("MemberDTO insert() 메서드 실행 완료");
           
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
           if(pstmt != null) {
              try {
                 pstmt.close();
              } catch (SQLException e) {
                 e.printStackTrace();
              }
           }
           
           if(conn != null) {
              try {
                 conn.close();
              } catch (SQLException e) {
                 e.printStackTrace();
              }
           }
        }
     }
  public void delete(int mNum) {
      Connection conn= null;
      PreparedStatement pstmt = null;
      
      String dbURL = "jdbc:mysql://127.0.0.1:3306/shoppingMall?useSSL=false";
      String dbID = "root";
      String dbPW = "rootroot";
      
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
         
         String sql = "delete from memberTBL where mNum = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, mNum);
         pstmt.executeUpdate();
         
         System.out.println("MemberDTO delete() 메서드 실행 완료");
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {

         e.printStackTrace();
      } finally {
         if(pstmt != null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         if(conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }
   
   
   public void update(int mNum, String mAddress) {
      Connection conn= null;
      PreparedStatement pstmt = null;
      
      String dbURL = "jdbc:mysql://127.0.0.1:3306/shoppingMall?useSSL=false";
      String dbID = "root";
      String dbPW = "rootroot";
      
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
         
         String sql = "update memberTBL set mAddress = ? where mNum = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mAddress);
         pstmt.setInt(2, mNum);
         pstmt.executeUpdate();
         
         System.out.println("MemberDTO update() 메서드 실행 완료");
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(pstmt != null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         if(conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }
   
   
   public void selectOne(int mNum) {
      Connection conn= null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String dbURL = "jdbc:mysql://127.0.0.1:3306/shoppingMall?useSSL=false";
      String dbID = "root";
      String dbPW = "rootroot";
      
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
         
         String sql = "select * from memberTBL where mNum = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, mNum);
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            MemberDTO dto = new MemberDTO();
            dto.setmNum(rs.getInt("mNum"));
            dto.setmID(rs.getString("mUserID"));
            dto.setmPW(rs.getString("mUserPW"));
     
            
            System.out.println(dto.toString());
         }
         
         System.out.println("MemberDTO selectOne() 메서드 실행 완료");
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(pstmt != null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         if(rs != null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         if(conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }
   
   public void selectAll() {
      Connection conn= null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String dbURL = "jdbc:mysql://127.0.0.1:3306/shoppingMall?useSSL=false";
      String dbID = "root";
      String dbPW = "rootroot";
      
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(dbURL, dbID, dbPW);
         
         String sql = "select * from memberTBL";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
         
         while(rs.next()) {
            MemberDTO dto = new MemberDTO();
            dto.setmNum(rs.getInt("mNum"));
            dto.setmID(rs.getString("mUserID"));
            dto.setmPW(rs.getString("mUserPW"));
          
            
            list.add(dto);
         }
         
         for(MemberDTO m : list) {
            System.out.println(m.toString());
         }
         
         System.out.println("MemberDTO selectAll() 메서드 실행 완료");
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if(pstmt != null) {
            try {
               pstmt.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         if(rs != null) {
            try {
               rs.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         if(conn != null) {
            try {
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }
}
