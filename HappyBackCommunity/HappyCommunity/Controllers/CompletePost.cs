using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.Sqlite;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace HappyCommunity.Controllers
{
	[Route("api/[controller]")]
	public class CompletePost : Controller
	{
		[HttpGet("{info}")]
		public IActionResult Get(HttpRequestMessage request, string username, int postid, int reward)
		{
			String userWhoCompletedTask = "";

			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
			    String sql = $"UPDATE PostTask SET Status = 2 WHERE ID = {postid};";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{

						}
					}
				}
				String sql1 = $"Select UserHandlingTask FROM PostTask WHERE ID = {postid};";
				using (SqliteCommand cmd = new SqliteCommand(sql1, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{
							userWhoCompletedTask = rdr["UserHandlingTask"].ToString();
						}
					}
				}
				String sql2 = $"UPDATE Users SET CurrentPoints = CurrentPoints + {reward} WHERE UserName =\"{userWhoCompletedTask}\";";
				using (SqliteCommand cmd = new SqliteCommand(sql2, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{

						}
					}
				}
				String sql3 = $"UPDATE Users SET CurrentPoints = CurrentPoints - {reward} WHERE UserName =\"{username}\";";
				using (SqliteCommand cmd = new SqliteCommand(sql3, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{

						}
					}
				}


			}

			return Ok();
		}

	}
}
