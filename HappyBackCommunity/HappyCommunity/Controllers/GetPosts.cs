﻿using System;
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
		[HttpGet("{status}")]
		public IEnumerable<PostOverviewModel> Get(int status)
		{
			List<PostOverviewModel> Posts  = new List<PostOverviewModel>();
			using (SqliteConnection c = new SqliteConnection("Data Source=HappyCommunity.db"))
			{
				c.Open();
				String sql = $"Select Posts.id, Title, Reward, Posts.Name, City, Posts.UserName FROM Posts Inner JOIN Users on Posts.UserName = Users.UserName INNER JOIN PostTask ON Posts.ID = PostTask.ID where PostTask.Status = {status};";

				using (SqliteCommand cmd = new SqliteCommand(sql, c))
				{
					
					using (SqliteDataReader rdr = cmd.ExecuteReader())
					{
						while (rdr.Read())
						{
							Posts.Add(new Types.PostOverviewModel()
							{
								Id = Int32.Parse(rdr["ID"].ToString()),
								Title = rdr["Title"].ToString(),
								Reward = Int32.Parse(rdr["Reward"].ToString()),
								Name = rdr["Name"].ToString(),
								City = rdr["City"].ToString(),
								UserName = rdr["UserName"].ToString()

							}) ;
						}
					}
				}
			}


			return Posts;
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
