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
	public class CreateUser : Controller
	{
		[HttpGet("{info}")]
		public IActionResult Get(HttpRequestMessage request, string username, string password, string name, string address, int phonenumber, int zipcode, string city)
		{
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
				String sql = $"INSERT INTO LoginDetails(UserName, Password) VALUES(\"{username}\", \"{password}\");";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					try
					{
						using (SqliteDataReader rdr = cmd.ExecuteReader())
						{
						
						}
					}
					catch (SqliteException e)
					{
						return Conflict();
					}
				}

				c.Open();
				String sql1 = $"INSERT INTO Users(UserName, Name, Address, PhoneNumber, ZipCode, City, CountryCode, CurrentPoints) VALUES(\"{username}\", \"{name}\", \"{address}\", {phonenumber}, {zipcode}, \"{city}\", 45, 100);";
				using (SqliteCommand cmd = new SqliteCommand(sql1, c))
				{
					
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
					}
				}
				return Ok();

			}
		}
	}
}
