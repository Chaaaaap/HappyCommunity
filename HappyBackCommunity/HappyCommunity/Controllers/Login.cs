using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using HappyCommunity.Types;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.Sqlite;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace HappyCommunity.Controllers
{
	[Route("api/[controller]")]
	public class Login : Controller
	{
		// GET: api/<controller>
		[HttpGet]
		public IEnumerable<string> Get()
		{
			return new string[] { "value1", "value2" };
		}

		// GET api/<controller>/5
		[HttpGet("{info}")]
		public ActionResult<User> Get(HttpRequestMessage request, string username, string password)
		{
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
				String sql = $"SELECT * FROM LoginDetails NATURAL JOIN Users where UserName = \"{username}\"";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{
							if (rdr["Password"].ToString() == password)
							{
								return Ok(new User()
								{
									UserName = rdr["UserName"].ToString(),
									Name = rdr["Name"].ToString(),
									Points = Int32.Parse(rdr["CurrentPoints"].ToString()),
									Address = rdr["Address"].ToString(),
									ZipCode = Int32.Parse(rdr["ZipCode"].ToString()),
									City = rdr["City"].ToString(),
									PhoneNumber = Int32.Parse(rdr["PhoneNumber"].ToString()),
									CountryCode = Int32.Parse(rdr["CountryCode"].ToString())

								}) ; ; 
								// Correct pw
							}
							else
							{
								return Unauthorized();
								// Wrong pw
							}

								
						}
						return NotFound();
						// Username not found
					}
				}
			}

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
