﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using HappyCommunity.Types;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.Sqlite;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace HappyCommunity.Controllers
{
	[Route("api/[controller]")]
	public class GetPost : Controller
	{
		// GET: api/<controller>
		[HttpGet]
		public IEnumerable<string> Get()
		{
			return new string[] { "value1", "value2" };
		}

		// GET api/<controller>/5
		[HttpGet("{id}")]
		public Post Get(int id)
		{

			Post post = null;
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
				String sql = $"Select Posts.ID, Title, Reward, Description, Name, City, ZipCode from Posts INNER JOIN Users on Posts.CreatorID = Users.ID where Posts.ID = {id}";
				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{
							post = new Post()
							{
								Id = Int32.Parse(rdr["ID"].ToString()),
								Title = rdr["Title"].ToString(),
								Reward = Int32.Parse(rdr["Reward"].ToString()),
								Creator = rdr["Name"].ToString(),
								City = rdr["City"].ToString(),
								ZipCode = Int32.Parse(rdr["ZipCode"].ToString()),
								Description = rdr["Description"].ToString()
								

							} ;
						}
        }
				}
			}
			return post;
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
