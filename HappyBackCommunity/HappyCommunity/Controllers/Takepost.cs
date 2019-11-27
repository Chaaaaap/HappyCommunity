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
	public class Takepost : Controller
	{
		[HttpGet("{info}")]
		public IActionResult Get(HttpRequestMessage request, string username, int postid)
		{
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
			    String sql = $"UPDATE PostTask SET Status = 1, UserHandlingTask = \"{username}\" WHERE ID = {postid};";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
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
