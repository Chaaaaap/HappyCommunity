using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using HappyCommunity.Types;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.Sqlite;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace HappyCommunity.Controllers
{
	[Route("api/[controller]")]
	public class GetPosts : Controller
	{
		// GET: api/<controller>
		[HttpGet]
		public IEnumerable<string> Get()
		{
			List<Post> Posts  = new List<Post>();
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
				String sql = "SELECT * from Posts;";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{
							Posts.Add(new Types.Post()
							{
								Id = Int32.Parse(rdr["ID"].ToString()),
								Creator = rdr["

							});
							Console.WriteLine(rdr["ID"]);
							res = rdr["ID"].ToString();
							res1 = rdr["Description"].ToString();
						}
        }
				}
			}


			return new string[] { res, res1, "value1", "value2" };
		}

		// GET api/<controller>/5
		[HttpGet("{id}")]
		public string Get(int id)
		{
			return "value";
		}

		// POST api/<controller>
		[HttpPost]
		public void Post([FromBody]string value)
		{
		}

		// PUT api/<controller>/5
		[HttpPut("{id}")]
		public void Put(int id, [FromBody]string value)
		{
		}

		// DELETE api/<controller>/5
		[HttpDelete("{id}")]
		public void Delete(int id)
		{
		}
	}
}
