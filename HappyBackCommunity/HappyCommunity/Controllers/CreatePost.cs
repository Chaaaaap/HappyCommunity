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
	public class CreatePost : Controller
	{
		[HttpGet("{info}")]
		public IActionResult Get(HttpRequestMessage request, int creatorID, string title, int reward, string description)
		{
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();

				string sql = $"INSERT INTO \"Posts\"(CreatorID, Title, Reward, Description) VALUES({creatorID}, '{title}', {reward}, '{description}');";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						// Username not found
						return Ok();
					}
				}
			}

		}

	}
}
